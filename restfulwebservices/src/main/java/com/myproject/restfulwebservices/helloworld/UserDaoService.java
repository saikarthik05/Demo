package  com.myproject.restfulwebservices.helloworld;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.util.StopWatch;

import com.google.common.base.Stopwatch;
import com.myproject.restfulwebservices.users.Users;

@Component

public class UserDaoService {

	public List<Users> arraylistmethog() {
		List<Users> use = new ArrayList<>();
		use.add(new Users(1, "karthik", new Date()));
		use.add(new Users(2, "prakash", new Date()));
		use.add(new Users(3, "sai", new Date()));
		use.add(new Users(4, "vinay", new Date()));
		int count = use.size();

		return use;
	}

	public List<Users> findall() {
		List<Users> userslist = arraylistmethog();
		return userslist;
	}

	public List<Users> save(Users user) {
		StopWatch s = new StopWatch();
		s.start();
		arraylistmethog().add(user);
		//userslist.add(user);
		String f =UUID.randomUUID().toString();
		long namotime =System.nanoTime();
		s.stop();
		System.out.println("execution time"+s);	
		//Stopwatch.stop();
		return arraylistmethog();
	}

	public List<Users> findbyId(String name) {
		List<Users> userslist = arraylistmethog();
		List<Users> user = userslist.stream().filter(y -> y.getName().equals(name)).collect(Collectors.toList());
				if(user.isEmpty() || user ==  null) {
					throw new UserNotFoundException("name is "+name);
				}else {
					return user;
				}
		
		
	}
	
	public List<Users> deleteById(String name){
		List<Users> userslist3 = new ArrayList<>();
		List<Users> userslist2 = arraylistmethog();
		Iterator<Users> user = userslist2.iterator();
		while(user.hasNext()){
			Users u = user.next();
			if(u.getName().equals(name)) {
				user.remove();
				//userslist3.add(u);
				//return user;
			}else {
				userslist3.add(u);
			}
			
					
		}
		return userslist3;
		
	}
	
	
	
	
}
