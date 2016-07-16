package com.coverxiaoeye.mockitodemo.personservice;

public interface PersonDao
{
    public Person fetchPerson( Integer personID );
    public void update( Person person );
}

