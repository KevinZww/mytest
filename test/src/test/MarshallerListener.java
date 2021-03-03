package test;

import javax.xml.bind.Marshaller;
import java.lang.reflect.Field;


public class MarshallerListener extends Marshaller.Listener{
    public static final String BLANK_CHAR = "";
    @Override
    public void beforeMarshal(Object source) {
        super.beforeMarshal(source);
        Field[] fields = source.getClass().getDeclaredFields();
        for (Field f : fields) {
            f.setAccessible(true);
            try {
                if (f.getType() == String.class && f.get(source) == null) {
                    f.set(source, BLANK_CHAR);
                }
            } catch (IllegalAccessException e) {
                //LOG.error(e.getMessage(),e);
            }
        }
    }
}
