package com.qr_storeage.QR_StoragePt2;

import com.qr_storeage.QR_StoragePt2.Models.Auth.ERole;
import com.qr_storeage.QR_StoragePt2.Models.Items.ECond;
import com.qr_storeage.QR_StoragePt2.Models.Items.ELocationTag;
import com.qr_storeage.QR_StoragePt2.Models.Items.EStatus;
import com.qr_storeage.QR_StoragePt2.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@SpringBootApplication
public class QrStoragePt2Application {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private StatusRepository statusRepository;

	@Autowired
	private CondRepository condRepository;

	@Autowired
	private LocationTagRepository locationTagRepository;

	@Value("${spring.datasource.driver-class-name}")
	public String myDriver;

	@Value("${spring.datasource.url}")
	public String myUrl;

	@Value("${spring.datasource.username}")
	public String username;

	@Value("${spring.datasource.password}")
	public String password;

	public static void main(String[] args) {
		SpringApplication.run(QrStoragePt2Application.class, args);
	}

	@Bean
	public void loadEnums(){
		int roleCheck = roleRepository.isRoleEmpty();
		int statusCheck = statusRepository.isStatusEmpty();
		int condCheck = condRepository.isCondEmpty();
		int tagCheck = locationTagRepository.isTagEmpty();

		if (roleCheck < ERole.values().length){
			int id = 1;
			for (ERole role : ERole.values()) {
				if (roleRepository.findByName(role).isEmpty()){
					try{
						Connection conn = DriverManager.getConnection(myUrl, username, password);
						Class.forName(myDriver);
						String query = "Insert into role (id, name) values (?,?)";
						PreparedStatement statement = conn.prepareStatement(query);

						statement.setString(1, Integer.toString(id));
						statement.setString(2, role.toString());

						statement.executeUpdate();
					} catch (Exception e){
						System.out.println(e.getMessage());
					}
				}
				id++;
			}
		}

		if (statusCheck < EStatus.values().length){
			int id = 1;
			for (EStatus status : EStatus.values()) {
				if (statusRepository.findByName(status).isEmpty()){
					try{
						Connection conn = DriverManager.getConnection(myUrl, username, password);
						Class.forName(myDriver);
						String query = "Insert into status (id, name) values (?,?)";
						PreparedStatement statement = conn.prepareStatement(query);

						statement.setString(1, Integer.toString(id));
						statement.setString(2, status.toString());

						statement.executeUpdate();
					} catch (Exception e){
						System.out.println(e.getMessage());
					}
				}
				id++;
			}
		}

		if (condCheck < ECond.values().length){
			int id = 1;
			for (ECond condition : ECond.values()) {
				if (condRepository.findByName(condition).isEmpty()){
					try{
						Connection conn = DriverManager.getConnection(myUrl, username, password);
						Class.forName(myDriver);
						String query = "Insert into cond (id, name) values (?,?)";
						PreparedStatement statement = conn.prepareStatement(query);

						statement.setString(1, Integer.toString(id));
						statement.setString(2, condition.toString());

						statement.executeUpdate();
					} catch (Exception e){
						System.out.println(e.getMessage());
					}
				}
				id++;
			}
		}

		if (tagCheck < ELocationTag.values().length){
			int id = 1;
			for (ELocationTag tag : ELocationTag.values()) {
				if (locationTagRepository.findByName(tag).isEmpty()){
					try{
						Connection conn = DriverManager.getConnection(myUrl, username, password);
						Class.forName(myDriver);
						String query = "Insert into location_tag (id, name) values (?,?)";
						PreparedStatement statement = conn.prepareStatement(query);

						statement.setString(1, Integer.toString(id));
						statement.setString(2, tag.toString());

						statement.executeUpdate();
					} catch (Exception e){
						System.out.println(e.getMessage());
					}
				}
				id++;
			}
		}

	}
}
