package samples;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ServiceSampleTest {

	@Test
	@DisplayName("saveLengthメソッドが正しくRepositoryに値を渡している")
	void saveLengthTestByMock() {

		RepositorySample repositoryMock = mock(RepositorySample.class);
		when(repositoryMock.saveLength("test")).thenReturn(4);
		ServiceSample service = new ServiceSample(repositoryMock);
		assertEquals(4, service.saveLengthOfServiceSample("test"));
		verify(repositoryMock, times(1)).saveLength("test");

	}

	@Test
	@DisplayName("saveLengthメソッドがRepositoryのsaveLengthImplを呼んでいる")
	void saveLengthTestBySpy() {

		RepositorySample repositorySpy = spy(RepositorySample.class);
		doReturn(4).when(repositorySpy).saveLengthImpl("test");
		ServiceSample service = new ServiceSample(repositorySpy);
		assertEquals(4, service.saveLengthOfServiceSample("test"));
		verify(repositorySpy, times(1)).saveLength("test");
		verify(repositorySpy, times(1)).saveLengthImpl("test");

	}

}
