package platform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CodeService {
    public final CodeRepository codeRepository;

    @Autowired
    public CodeService(CodeRepository codeRepository) {
        this.codeRepository = codeRepository;
    }

    public UUID addCode(CodeEntity toSave) {
        codeRepository.save(toSave);
        return toSave.getUuid();
    }

    public Optional<CodeEntity> findCodeEntityByUuid(UUID uuid) {
        return codeRepository.findCodeEntityByUuid(uuid);
    }

    public List<CodeEntity> findLatest() {
      return codeRepository.find10Latest();

    }

}
