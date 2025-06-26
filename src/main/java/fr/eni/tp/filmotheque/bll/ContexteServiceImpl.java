package fr.eni.tp.filmotheque.bll;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Primary
@Profile("dev")
public class ContexteServiceImpl {

}
