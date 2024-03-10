package com.kas.kasproy.errors;

import jakarta.validation.GroupSequence;

@GroupSequence({First.class, Second.class})
public interface ValidationOrder {}
