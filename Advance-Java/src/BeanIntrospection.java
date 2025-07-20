import java.beans.*;

public class BeanIntrospection {
    public static void main(String[] args) throws IntrospectionException {
        // Get bean information
        BeanInfo beanInfo = Introspector.getBeanInfo(UserBean.class);
        
        // Get property descriptors
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        
        System.out.println("Properties in UserBean:");
        for (PropertyDescriptor pd : propertyDescriptors) {
            // Skip "class" property inherited from Object
            if (!pd.getName().equals("class")) {
                System.out.println("- " + pd.getName() + " (" + pd.getPropertyType().getSimpleName() + ")");
                System.out.println("  Read method: " + pd.getReadMethod().getName());
                System.out.println("  Write method: " + pd.getWriteMethod().getName());
            }
        }
    }
}