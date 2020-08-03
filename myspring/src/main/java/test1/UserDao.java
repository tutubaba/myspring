package test1;
import org.springframework.stereotype.Repository;
@Repository
public class UserDao {
    public void printInfo(){
        System.out.println("user dao");
    }
}