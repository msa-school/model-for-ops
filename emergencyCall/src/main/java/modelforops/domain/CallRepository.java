package modelforops.domain;

import modelforops.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "calls", path = "calls")
public interface CallRepository
    extends PagingAndSortingRepository<Call, Long> {}
