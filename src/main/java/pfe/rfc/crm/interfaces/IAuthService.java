package pfe.rfc.crm.interfaces;

import org.springframework.web.multipart.MultipartFile;
import pfe.rfc.crm.dto.SignupRequest;

import java.io.IOException;

public interface IAuthService {
    boolean createUser(SignupRequest signupRequest) throws IOException;


}
