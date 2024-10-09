package blog.tsuchiya.mockito_test;

public class Main {

	public static void main(String[] args) {

		RepositorySample repository = new RepositorySample();
		ServiceSample service = new ServiceSample(repository);
		int returnLength = service.saveLengthOfServiceSample("test");
		System.out.println("return length : " + returnLength);

	}

}
