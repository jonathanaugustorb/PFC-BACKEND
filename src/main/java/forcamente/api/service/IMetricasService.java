package forcamente.api.service;

import forcamente.api.dto.VolumeTreinoRequestDTO;
import forcamente.api.dto.VolumeTreinoResponseDTO;

public interface IMetricasService {

    VolumeTreinoResponseDTO calcularVolumeTreino(VolumeTreinoRequestDTO volumeTreinoRequestDTO);

}
