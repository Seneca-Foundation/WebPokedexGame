package com.senecafoundation.webpokedexgame.DataHandler.Interfaces;

public interface IDataWriter<T> extends IDataWriterCreate<T>, IDataWriterRead<T>, IDataWriterUpdate<T>, IDataWriterDelete<T> {
    
}