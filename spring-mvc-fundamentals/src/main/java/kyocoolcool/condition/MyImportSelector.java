package kyocoolcool.condition;

import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @ClassName MyImportSelector
 * @Description 自定義邏輯返回要導入的組件
 * @Author chris
 * @Date 2019-03-18 19:22
 * @Version 1.0
 **/

public class MyImportSelector implements ImportSelector {
//    AnnotationMetadata:當前@Import所有註解訊息
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"kyocoolcool.bean.Yellow","kyocoolcool.bean.Bule"};
    }
}