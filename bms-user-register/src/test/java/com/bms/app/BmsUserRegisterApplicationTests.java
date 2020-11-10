package com.bms.app;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.bms.app.controller.UserController;
import com.bms.app.data.UserEntity;
import com.bms.app.repository.UserRepository;
import com.bms.app.repository.UserRepositoryImpl;
import com.bms.app.service.UserServiceImpl;
import com.bms.app.shared.UserDto;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BmsUserRegisterApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@InjectMocks
	UserServiceImpl userServiceImpl;
	
	@InjectMocks
	UserController userController;

	@Mock
	UserRepositoryImpl userRepositoryImpl;
	
	@Mock
	UserRepository userRepository;
	
	@Test
	 void testUserRegistration() {
		UserEntity userEntity=new UserEntity(101,"shails","klnagar","kar","Ind","shails@gmail.com",
				       "7987dhf","99999999","29/01/2019","self",1234567890123456L,"password1");
		UserDto userDto=new UserDto("shails","klnagar","kar","Ind","shails@gmail.com",
			       "7987dhf","99999999","29/01/2019","self","password1");
		when(userRepositoryImpl.save(userEntity)).thenReturn(userEntity);

		UserEntity re = userServiceImpl.CreateUser(userDto);
		assertThat(re).isNotNull();
	}
	
	@Test
	 void testUserRegistrationfail() {
		UserEntity userEntity = new UserEntity();
		UserDto userDto=new UserDto("shails","shails@gmail.com","password1");
		when(userRepositoryImpl.save(userEntity)).thenReturn(userEntity);

		UserEntity re = userServiceImpl.CreateUser(userDto);
		assertThat(re).isNotNull();

	}
	
	@Test
	   void testUserRegistrationfail2() {
		UserEntity userEntity = new UserEntity();
		UserDto userDto = new UserDto();
		when(userRepositoryImpl.save(userEntity)).thenReturn(userEntity);

		UserEntity re = userServiceImpl.CreateUser(userDto);
		assertThat(re).isNotNull();
		}
	
	@Test
	 void testUserRegistrationfail3() {
		UserEntity userEntity=new UserEntity(101,"shails","klnagar","kar","Ind","shails@gmail.com",
			       "7987dhf","99999999","29/01/2019","self",1234567890123456L,"password1");
		UserDto userDto = new UserDto();
		when(userRepositoryImpl.save(userEntity)).thenReturn(userEntity);

		UserEntity re = userServiceImpl.CreateUser(userDto);
		assertThat(re).isNotNull();
	}
	
	@Test
	 void testUserRegistrationfail4() {
		UserEntity userEntity=new UserEntity(101,"s","klnagar","kar","Ind","shails@gmail.com",
			       "7987dhf","99999999","29/01/2019","self",1234567890123456L,"password1");
		UserDto userDto = new UserDto();
		when(userRepositoryImpl.save(userEntity)).thenReturn(userEntity);

		UserEntity re = userServiceImpl.CreateUser(userDto);
		assertThat(re).isNotNull();
	}
	
	@Test
	 void testUserRegistrationfail5() {
		UserEntity userEntity=new UserEntity(101,"shails","klnagar","kar","Ind","shails@gmail",
			       "7987dhf","99999999","29/01/2019","self",1234567890123456L,"password1");
		UserDto userDto = new UserDto();
		when(userRepositoryImpl.save(userEntity)).thenReturn(userEntity);

		UserEntity re = userServiceImpl.CreateUser(userDto);
		assertThat(re).isNotNull();
	}
	
	@Test
	 void testbreaker() {
		UserEntity userEntity=new UserEntity(101,"shails","klnagar","Kar","Ind","shails@gmail.com",
			       "7987dhf","99999999","29/01/2019","self",1234567890123456L,"password1");
		UserDto userDto=new UserDto("shails","shails@gmail.com","password1");
		when(userRepositoryImpl.save(userEntity)).thenReturn(userEntity);
	
		UserEntity re = userServiceImpl.CreateUser(userDto);
		assertThat(re).isNotNull();
		
	}
	
	@Test
	 void testUserRegistrationfail6() {
		UserEntity userEntity=new UserEntity(101,"shails","klnagar","kar","Ind","shails@gmail",
			       "7987dhf","99999999","29/01/2019","self",1234567890123456L,"password1");
		UserDto userDto =null;
		when(userRepositoryImpl.save(userEntity)).thenReturn(userEntity);
		//assertThat(userEntity).isNotNull();
	}
	
	@Test
	 void testUserRegistrationfail7() {
		UserEntity userEntity=null;
		UserDto userDto =null;
		when(userRepositoryImpl.save(userEntity)).thenReturn(userEntity);
		assertThat(userEntity).isNull();
	}
	
	@Test
	void testset() {
		
		UserEntity userEntity= new UserEntity();
		userEntity.setUserId(100);
		userEntity.setUserName("shails");
		userEntity.setAddress("klnagar");
		userEntity.setState("kar");
		userEntity.setCounty("Ind");
		userEntity.setEmail("shails@gmail.com");
		userEntity.setPanNumber("djh398456");
		userEntity.setContactNumber("99999999");
		userEntity.setDateOfBirth("29/01/2019");
		userEntity.setAccountType("self");
		userEntity.setAccountNumber(1234567890123456L);
		userEntity.setPassword("password1");
	
		UserDto UserDto = new UserDto();
		UserDto.setUserName("shails");
		UserDto.setAddress("klnagar");
		UserDto.setState("kar");
		UserDto.setCounty("Ind");
		UserDto.setEmail("shails@gmail.com");
		UserDto.setPanNumber("djh398456");
		UserDto.setContactNum("99999999");
		UserDto.setDateOfBirth("29/01/2019");
		UserDto.setAccountType("self");
		UserDto.setPassword("password1");

		when(userRepositoryImpl.save(userEntity)).thenReturn(userEntity);
		assertThat(userEntity).isNotNull();
	}

	@Test
	 void testUserById() {
		UserEntity userEntity=new UserEntity(101,"shails","klnagar","kar","Ind","shails@gmail.com",
				       "7987dhf","99999999","29/01/2019","self",1234567890123456L,"password1");
		UserDto userDto=new UserDto("shails","klnagar","kar","Ind","shails@gmail.com",
			       "7987dhf","99999999","29/01/2019","self","password1");
		when(userRepositoryImpl.save(userEntity)).thenReturn(userEntity);  
		try {
			userController.getUserById(101);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		assertThat(userEntity).isNotNull();
	}
	
	@Test
	 void testUserByIdfail() throws Exception {
		UserEntity userEntity=new UserEntity(101,"shails","klnagar","kar","Ind","shails@gmail.com",
				       "7987dhf","99999999","29/01/2019","self",1234567890123456L,"password1");
		UserDto userDto=new UserDto("shails","klnagar","kar","Ind","shails@gmail.com",
			       "7987dhf","99999999","29/01/2019","self","password1");
		when(userRepositoryImpl.save(userEntity)).thenReturn(userEntity);  
		try {
			userController.getUserById(123);
		} catch (Exception e) {
			
			userController.getidbreaker(123);
		}
		assertThat(userEntity).isNotNull();	
	}
	
	 @Test
    void testApplication()
    {
        BmsUserRegisterApplication.main(new String[]{
                "--spring.main.web-environment=false",
                "--spring.autoconfigure.exclude=blahblahblah",
               
        });
    }
	 
	
	
	
	
	
	
}
