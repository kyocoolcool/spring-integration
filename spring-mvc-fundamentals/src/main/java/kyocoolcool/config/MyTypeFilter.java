package kyocoolcool.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @ClassName MyTypeFilter
 * @Description TODO
 * @Author chris
 * @Date 2019-03-18 11:25
 * @Version 1.0
 **/

public class MyTypeFilter implements TypeFilter {
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        //獲取當前註解的訊息
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        //獲取當前正在掃描類的類訊息
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        //獲取當前類的資源訊息(class path)
        Resource resource = metadataReader.getResource();
        //獲取Class name
        String className = classMetadata.getClassName();
        System.out.println("------>"+className);
        if(className.contains("er"))
            return true;
        return false;
    }
}