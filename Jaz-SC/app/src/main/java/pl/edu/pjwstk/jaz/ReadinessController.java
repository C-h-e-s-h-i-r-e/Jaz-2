package pl.edu.pjwstk.jaz;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@RestController
public class ReadinessController {
    @PersistenceContext
    private EntityManager em;

    @PreAuthorize("hesAnyAuthority('viev-readiness', 'admin')")
    @Transactional
    @GetMapping("/is-ready")
    public void readinessTest() {
        var entity = new Test1Entity();
        entity.setName("sdavsda");
        em.persist(entity);
    }
}