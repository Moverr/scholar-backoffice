package com.codemovers.scholar.v1.backoffice.helper.annotation;

/**
 * Created by mover on 5/6/2017.
 */
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = {ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MainId {

}
