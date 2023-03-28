package untitled.domain;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import untitled.domain.*;

@RepositoryRestResource(collectionResourceRel = "cooks", path = "cooks")
public interface CookRepository
    extends PagingAndSortingRepository<Cook, Long> {}
