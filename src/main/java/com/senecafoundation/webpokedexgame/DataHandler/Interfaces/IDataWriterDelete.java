package com.senecafoundation.webpokedexgame.DataHandler.Interfaces;

import java.util.UUID;

public interface IDataWriterDelete<T> {
    public Boolean Delete(UUID ID) throws Exception;
}
