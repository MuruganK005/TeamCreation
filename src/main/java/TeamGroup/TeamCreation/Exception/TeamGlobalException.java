package TeamGroup.TeamCreation.Exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TeamGlobalException{
    private Logger logger = LoggerFactory.getLogger(TeamGlobalException.class);
    @ExceptionHandler(value =TeamException.class)
    public ResponseEntity<?> handleTeamException(TeamException exception) {
        logger.error("Team exception: {}", exception.getErrorMessage());
        return new ResponseEntity<>(ErrorResponse.builder().message(exception.getErrorMessage()).build(), exception.getStatus());
    }
}