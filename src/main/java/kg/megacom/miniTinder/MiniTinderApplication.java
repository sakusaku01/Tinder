package kg.megacom.miniTinder;


import com.google.gson.Gson;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import kg.megacom.miniTinder.models.Acount;
import kg.megacom.miniTinder.services.OperationAutServices;
import kg.megacom.miniTinder.services.OperationOrderServices;
import kg.megacom.miniTinder.services.OperationServices;
import kg.megacom.miniTinder.services.impl.OperationAutServicesImpl;
import kg.megacom.miniTinder.services.impl.OperationOrderServicesImpl;
import kg.megacom.miniTinder.services.impl.OperationServicesImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;


public class MiniTinderApplication {

	public static void main(String[] args) throws IOException {


		String url1 = "http://localhost:8086/api/v1/main/country/get?id=1";
		OkHttpClient okHttpClient=new OkHttpClient();
		Request  request=new Request.Builder()
				.url(url1)
				.build();
		Call call =okHttpClient.newCall(request);
		Response response;

		try{
			response=call.execute();
			System.out.println(response.code());
			System.out.println(response.body().string());
		}catch (IOException e){
			throw new RuntimeException(e.getMessage());
		}

		Gson gson = new Gson();
		Countries countries = gson.fromJson(response.body().string(),Countries.class);
//
//		String result = response.body().string();
//		System.out.println(result);



//		Scanner scanner = new Scanner(System.in);
//
//		OperationServices operationServices = new OperationServicesImpl();
//		OperationAutServices operationAutServices = new OperationAutServicesImpl();
//
//		OperationOrderServices operationOrderServices = new OperationOrderServicesImpl();
//
//
//		while (true) {
//			System.out.println("Выберите действие ");
//			System.out.println("1 регистрация");
//			System.out.println("2 вход");
//			switch (scanner.nextInt()){
//				case 1:
//					System.out.println(operationServices.registration());
//					break;
//				case 2:
//					operationAutServices.authorization();
//					break;
//			}
//
//		}

	}
	public class Countries {

		private Long id;
		private String name;


		public Countries() {
		}

		public Countries(Long id, String name) {
			this.id = id;
			this.name = name;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "id=" + id +
					", name='" + name + '\'';
		}
	}
}
