package com.paulomoura.dependencyinjection.core

/**
 * Exception that is thrown when the DI Application Context is null when accessed.
 */
class DINullApplicationContextException : RuntimeException("Project's Main Activity must be of type DIActivity")