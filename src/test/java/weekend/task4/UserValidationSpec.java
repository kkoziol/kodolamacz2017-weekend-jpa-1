package weekend.task4;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class UserValidationSpec {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	User SUT; // System Under Test

	private Set<ConstraintViolation<User>> validateClass(User myClass) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<User>> violations = validator.validate(myClass);
		return violations;
	}
	private Set<ConstraintViolation<User>> validateField(Class myClass,String pole, Object value) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<User>> violations = validator.validateValue(myClass, pole, value);
		return violations;
	}

	@Before
	public void setup() {
		SUT = new User();
	}

	@Test
	public void whenRegistrationInFutureThenNotValid() {
		// Given Setup
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.HOUR, 3);
		Date date = c.getTime();

		// When Act
		Set<ConstraintViolation<User>> results = validateField(User.class, "registrationDate", date);

		// Then Verify
		assertThat(results).size().isEqualTo(1);
	}
	
	@Test
	public void whenPasswordToShortThenNotValid() {
		// Given Setup
		SUT.setPassword("33");

		// When Act
		Set<ConstraintViolation<User>> results = validateClass(SUT);

		// Then Verify
		assertThat(results).size().isGreaterThan(0);
		List<String> messages = new ArrayList<>();
		for (ConstraintViolation<User> constraintViolation : results) {
			messages.add(constraintViolation.getMessage());
			System.out.println(constraintViolation.getMessage());
		}
		assertThat(messages).contains("Hasło powinno mieć minimum 4 znaki!");
	}
}