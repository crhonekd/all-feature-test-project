package com.dave.lombok;

import lombok.experimental.Delegate;

public class Builders {

    @Delegate
    private final PersonBuilders personBuilder = new PersonBuilders();
    @Delegate
    private final AddressBuilders addressBuilder = new AddressBuilders();

}
