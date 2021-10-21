package com.senecafoundation.webpokedexgame.DataHandler;

import java.util.UUID;

public interface IDataWriterDelete<T> {
    public Boolean Delete(UUID ID) throws Exception;
}
