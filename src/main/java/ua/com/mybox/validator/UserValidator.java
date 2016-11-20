package ua.com.mybox.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import ua.com.mybox.entity.User;
import ua.com.mybox.service.UserService;

public class UserValidator implements Validator{

	private final UserService userService;

    public UserValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(User.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "", "email can't be empty");
        if(userService.findByEmail(user.getEmail()) != null){
            errors.rejectValue("email", "", "email already exist");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "", "username can't be empty");
        if(userService.findByUsername(user.getOriginUsername()) != null){
            errors.rejectValue("username", "", " username already exist");
        }


    }
}
