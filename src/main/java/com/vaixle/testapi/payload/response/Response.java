package com.vaixle.testapi.payload.response;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PROTECTED)
public abstract class Response {

    boolean success = true;
}
