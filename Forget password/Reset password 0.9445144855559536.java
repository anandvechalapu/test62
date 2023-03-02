
Controller:

@RestController
@RequestMapping("/forgetPassword")
public class ForgetPasswordController {

@Autowired
private ForgetPasswordService forgetPasswordService;

@PostMapping
public String resetPassword(@RequestBody String email) {
    return forgetPasswordService.resetPassword(email);
}

}

Service:

@Service
public class ForgetPasswordService {

@Autowired
private ForgetPasswordRepository forgetPasswordRepository;

public String resetPassword(String email) {
    Optional<User> user = forgetPasswordRepository.findByEmail(email);
    if (user.isPresent()) {
    
        //Send mail to user with reset link
        return "Mail sent to the user for resetting the password";
    }
    else {
        return "User not found";
    }
}

}

Repository:

@Repository
public interface ForgetPasswordRepository extends JpaRepository<User, Long> {

Optional<User> findByEmail(String email);

}