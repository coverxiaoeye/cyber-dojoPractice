package com.coverxiaoeye.mockitodemo.personservice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * 参考 Mockito：一个强大的用于 Java 开发的模拟测试框架
 * http://www.oschina.net/translate/mockito-a-great-mock-framework-for-java-development
 */
public class PersonServiceTest
{
    @Mock
    private PersonDao personDAO;
    private PersonService personService;
    @Before
    public void setUp()
            throws Exception
    {
        MockitoAnnotations.initMocks( this );
        personService = new PersonService( personDAO );
        // mock only one person
        Person person = new Person( 1, "Phillip" );
        when( personDAO.fetchPerson( 1 ) ).thenReturn( person );
        when( personDAO.fetchPerson( 2 ) ).thenReturn( null );
    }
    @Test
    public void shouldUpdatePersonName()
    {
        boolean updated = personService.update( 1, "David" );
        assertTrue( updated );
        verify( personDAO ).fetchPerson( 1 );
        ArgumentCaptor<Person> personCaptor = ArgumentCaptor.forClass( Person.class );
        verify( personDAO ).update( personCaptor.capture() );
        Person updatedPerson = personCaptor.getValue();
        assertEquals( "David", updatedPerson.getPersonName() );
        // asserts that during the test, there are no other calls to the mock object.
        verifyNoMoreInteractions( personDAO );
    }
    @Test
    public void shouldNotUpdateIfPersonNotFound()
    {
        boolean updated = personService.update( 2, "David" );
        assertFalse( updated );
        verify( personDAO ).fetchPerson( 2 );
        verifyZeroInteractions( personDAO );
        verifyNoMoreInteractions( personDAO );
    }
}