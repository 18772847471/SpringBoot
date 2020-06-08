package com.example.mymapperscan.business.myspring;


import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
   public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
       Map<String,Object> map =  importingClassMetadata.getAnnotationAttributes(MyMapperScan.class.getName());
       MyClassScaner cs = new MyClassScaner();
       BeanDefinition  beanDefinition = new RootBeanDefinition(MyFactoryBean.class);

       if(map != null) {
           Set<Class> set =null;
           for(Object object:map.values()) {
               set = cs.doScan(object.toString());

               Iterator it = set.iterator();
               while (it.hasNext()) {
                   Class clazz = (Class)it.next();
                   String className = clazz.getName();
                   beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(className);
                   String[] names = className.split("\\.");

                   String fStr = names[names.length-1].substring(0,1).toLowerCase();
                   String lStr = names[names.length-1].substring(1);
                   String name = fStr.concat(lStr);
                   registry.registerBeanDefinition(name,beanDefinition);
               }

           }
        }




   }
}
