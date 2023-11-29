package live.cloverescape.startimes.utils;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author weibb
 * @date 2023-11-27
 */
public class EntityUtils {

    /**
     * <code>
     *     <p>
     *         // 对 ApplicationsConfigDTO 进行操作
     * EntityUtils.setValues(appConfigDtos,
     *         ApplicationsConfigDTO::getAppApplicationListDictId,
     *         ids -> appApplicationListDictRepository.findByIdIn(ids)
     *                 .stream()
     *                 .collect(Collectors.toMap(AppApplicationListDict::getId, AppApplicationListDict::getName)),
     *         ApplicationsConfigDTO::setSelfInnovateLinkName,
     *         appConfigDto -> Objects.equals(appConfigDto.getLinkType(), LinkType.SELF_INNOVATE));
     *     </p>
     * </code>
     * @param entities 实体列表
     * @param keyExtractor 实体映射 key 提取器
     * @param valueMapProvider key 与 name 映射 map 提供者
     * @param nameSetter name 消费者
     * @param <T> 类型
     * @param <U> 类型
     */
    public static <T, U> void setValues(List<T> entities,
                                       Function<T, U> keyExtractor,
                                       Function<List<U>, Map<U, String>> valueMapProvider,
                                       BiConsumer<T, String> nameSetter,
                                        Predicate<T> filterCondition) {
        List<T> filteredEntities = entities.stream()
                .filter(filterCondition)
                .collect(Collectors.toList());
        List<U> ids = filteredEntities.stream()
                .map(keyExtractor)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        Map<U, String> idToNameMap = valueMapProvider.apply(ids);
        filteredEntities.forEach(entity -> {
            U entityId = keyExtractor.apply(entity);
            if (idToNameMap.containsKey(entityId)) {
                nameSetter.accept(entity, idToNameMap.get(entityId));
            }
        });
    }
}
