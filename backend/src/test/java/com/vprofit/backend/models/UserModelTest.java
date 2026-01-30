import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;

public class UserModelTest {
    private Validator validator;

    @BeforeEach 
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void naoDeveCriarUsuarioSemDados() {
        User user = new User();
        var validations = validator.validate(user);
        assertFalse(validations.isEmpty());
    }

    @Test 
    void userTableDeveSerSerializable(){
        User user = new User();
        assertTrue(user instanceof java.io.Serializable);
    }
}
