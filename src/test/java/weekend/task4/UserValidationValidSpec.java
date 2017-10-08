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

public class UserValidationValidSpec {

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	VIPUser SUT; // System Under Test
	User user;

	private Set<ConstraintViolation<VIPUser>> validateClass(VIPUser myClass) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<VIPUser>> violations = validator.validate(myClass);
		return violations;
	}
	private Set<ConstraintViolation<VIPUser>> validateField(Class myClass,String pole, Object value) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<VIPUser>> violations = validator.validateValue(myClass, pole, value);
		return violations;
	}

	@Before
	public void setup() {
		SUT = new VIPUser();
		user = new User();
		SUT.setUser(user);
	}

	@Test
	public void whenPasswordToShortThenNotValid() {
		// Given Setup
		user.setPassword("33");

		// When Act
		Set<ConstraintViolation<VIPUser>> results = validateClass(SUT);

		// Then Verify
		assertThat(results).size().isGreaterThan(0);
		List<String> messages = new ArrayList<>();
		for (ConstraintViolation<VIPUser> constraintViolation : results) {
			messages.add(constraintViolation.getMessage());
			System.out.println(constraintViolation.getMessage());
		}
		assertThat(messages).contains("Hasło powinno mieć minimum 4 znaki!");
		assertThat(messages).contains("may not be null");
	}
}