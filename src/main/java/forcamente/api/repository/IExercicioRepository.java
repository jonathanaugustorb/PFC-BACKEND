package forcamente.api.repository;

import forcamente.api.entity.ExercicioEntity;
import forcamente.api.entity.enums.GrupoMuscularEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IExercicioRepository extends JpaRepository<ExercicioEntity, UUID> {

    List<ExercicioEntity> findByGrupoMuscular(GrupoMuscularEnum grupoMuscular);

    boolean existsByNome(String nome);
}
