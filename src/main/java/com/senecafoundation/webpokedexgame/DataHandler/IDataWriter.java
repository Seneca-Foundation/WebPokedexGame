package com.senecafoundation.webpokedexgame.DataHandler;

public interface IDataWriter<T> extends IDataWriterCreate<T>, IDataWriterRead<T>, IDataWriterUpdate<T>, IDataWriterDelete<T> {
    
}