import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


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

    @Test
    void userDeveTerFieldsEspecificos() {
        User user = new User();
        var campos = java.util.Arrays.stream(User.class.getDeclaredFields())
            .map(field -> field.getName())
            .toList();
        assertTrue(campos.contains("id"));
        assertTrue(campos.contains("firstName"));
        assertTrue(campos.contains("lastName"));
        assertTrue(campos.contains("email"));
        assertTrue(campos.contains("password"));
        assertTrue(campos.contains("createdAt"));
        assertTrue(campos.contains("updatedAt"));
        assertTrue(campos.contains("isActive"));
    
    }
}
