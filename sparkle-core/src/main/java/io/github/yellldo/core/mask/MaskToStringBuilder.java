package io.github.yellldo.core.mask;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

/**
 * ClassName : MaskToStringBuilder<br>
 * Description : 掩码对象toString方法builder模式，将被注解{@link LogMask}标注内容进行脱敏操作<br>
 *
 * @author : sj
 * @version : 1.0.0
 * @date : 2021/2/16
 * @see org.apache.commons.lang3.builder.ReflectionToStringBuilder
 */
public class MaskToStringBuilder extends ReflectionToStringBuilder {

    /**
     * <p>
     * Constructor.
     * </p>
     * <p>
     * <p>
     * This constructor outputs using the default style set with <code>setDefaultStyle</code>.
     * </p>
     *
     * @param object the Object to build a <code>toString</code> for, must not be <code>null</code>
     * @throws IllegalArgumentException if the Object passed in is <code>null</code>
     */
    public MaskToStringBuilder(Object object) {
        super(object);
    }

    /**
     * <p>
     * Constructor.
     * </p>
     * <p>
     * <p>
     * If the style is <code>null</code>, the default style is used.
     * </p>
     *
     * @throws IllegalArgumentException if the Object passed in is <code>null</code>
     */
    public MaskToStringBuilder(Object object, ToStringStyle style) {
        super(object, style);
    }

    /**
     * <p>
     * Appends the fields and values defined by the given object of the given Class.
     * </p>
     * <p>
     * <p>
     * If a cycle is detected as an object is &quot;toString()'ed&quot;, such an object is rendered as if
     * <code>Object.toString()</code> had been called and not implemented by the object.
     * </p>
     *
     * @param clazz The class of object parameter
     */
    @Override
    protected void appendFieldsIn(Class clazz) {
        if (clazz.isArray()) {
            this.reflectionAppendArray(this.getObject());
            return;
        }
        final Field[] fields = clazz.getDeclaredFields();
        AccessibleObject.setAccessible(fields, true);
        for (final Field field : fields) {
            final String fieldName = field.getName();
            if (this.accept(field)) {
                try {
                    Object fieldValue = this.getValue(field);
                    if (fieldValue == null) {
                        continue;
                    }
                    //if need mask
                    LogMask mask = field.getAnnotation(LogMask.class);
                    if (mask != null) {
                        fieldValue = mask.value().mask(fieldValue.toString());
                    }

                    // Warning: Field.get(Object) creates wrappers objects
                    // for primitive types.
                    this.append(fieldName, fieldValue);
                } catch (IllegalAccessException ex) {
                    //this can't happen. Would get a Security exception
                    // instead
                    //throw a runtime exception in case the impossible
                    // happens.
                    throw new InternalError("Unexpected IllegalAccessException: " + ex.getMessage());
                }
            }
        }
    }


}
