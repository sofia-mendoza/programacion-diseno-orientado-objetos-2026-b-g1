package com.corhuila.proyecto.mapper;

import com.corhuila.proyecto.dto.ComponenteDTO;
import com.corhuila.proyecto.dto.KitDTO;
import com.corhuila.proyecto.model.Kit;

import java.util.List;

public final class KitMapper {

    private KitMapper() {
    }

    public static KitDTO aDto(Kit kit) {
        List<ComponenteDTO> componentes = kit.getComponentes().stream()
                .map(ComponenteMapper::aDto)
                .toList();
        return new KitDTO(kit.getId(), kit.getCodigo(), kit.getNombre(), componentes);
    }

    // Un kit nuevo nace vacío; sus componentes se agregan después con agregarComponente
    public static Kit aEntidad(KitDTO dto) {
        return new Kit(dto.nombre());
    }
}
