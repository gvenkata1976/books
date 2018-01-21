import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.library.domain.Contact;
import com.library.domain.Role;
import com.library.domain.User;

public class Test {
 public static void main(String[] args) {
		User user = new User();
		user.setLogin("ganesh");
		user.setUsername("ganesh");
		user.setPassword("ganesh");
		Contact contact = new Contact(); 
		contact.setEmail("sys@def.com");
		contact.setPhone("090909098888");
		user.setContact(contact);
		Set<Role> roles = new HashSet<Role>();
		Role r1 = new Role();
		r1.setAuthority("ADMIN_ROLE");
		roles.add(r1);
		Role r2 = new Role();
		r2.setAuthority("USER_ROLE"); 
		roles.add(r2);
		user.setAuthorities(roles);
		user.setAccountNonLocked(true);
		user.setEnabled(true);
		user.setCredentialsNonExpired(true);
		user.setAccountNonExpired(true); 
		
		ObjectMapper m = new ObjectMapper();
		try {
			m.writeValue(new File("user.json"), user);
			System.out.println(m.readValue(new File("user.json"), User.class));
		} catch (IOException e) {
 			e.printStackTrace();
		}
}
}
