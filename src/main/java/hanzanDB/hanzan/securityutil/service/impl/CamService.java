package hanzanDB.hanzan.securityutil.service.impl;

import com.nimbusds.jose.shaded.json.JSONObject;
import hanzanDB.hanzan.data.entity.Food;
import hanzanDB.hanzan.data.entity.Product;
import hanzanDB.hanzan.data.entity.dao.FoodDAO;
import hanzanDB.hanzan.data.entity.dao.ProductDAO;
import hanzanDB.hanzan.data.entity.dto.CamPostDto;
import hanzanDB.hanzan.data.entity.dto.Response.Cam.FoodCamResponseDto;
import hanzanDB.hanzan.data.entity.dto.Response.Cam.ProductCamResponseDto;
import hanzanDB.hanzan.data.entity.dto.Response.Product.ProductResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class CamService {
    @Value("${hanzan.nlp.url}")
    private String nlpUrl;
    private final ProductDAO productDAO;
    private final FoodDAO foodDAO;
    @Autowired
    public CamService(ProductDAO productDAO, FoodDAO foodDAO) {
        this.productDAO = productDAO;
        this.foodDAO = foodDAO;
    }


    public List<String> camGet(CamPostDto camPostDto) throws IOException {

        List<String> returnStr = new ArrayList<>();
        URL url = new URL(nlpUrl);
        try{

            for(String str : camPostDto.getInputstring()) {
                String inputLine = null;
                StringBuffer outResult = new StringBuffer();
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestProperty("Content-Type", "application/json");
                conn.setRequestProperty("Accept-Charset", "UTF-8");
                conn.setConnectTimeout(10000);
                conn.setReadTimeout(10000);
                conn.setDoOutput(true);
                String jsonInputString = createRequestBody(camPostDto.getMode(), str).toString();
                OutputStream os = conn.getOutputStream();
                os.write(jsonInputString.getBytes("UTF-8"));
                os.flush();

                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                while ((inputLine = in.readLine()) != null) {
                    outResult.append(inputLine);
                }
                if(!outResult.toString().contains("None") &&
                        !returnStr.contains(outResult.toString())) {
                    returnStr.add(outResult.toString());
                }
                conn.disconnect();
            }


        }catch(Exception e){
            e.printStackTrace();
        }

        return returnStr;
    }

    public List<ProductCamResponseDto> camGetD(List<String> strings) throws IOException {

        List<ProductCamResponseDto> returnStr = new ArrayList<>();
        URL url = new URL(nlpUrl);
        try{

            for(String str : strings) {
                String inputLine = null;
                StringBuffer outResult = new StringBuffer();
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestProperty("Content-Type", "application/json");
                conn.setRequestProperty("Accept-Charset", "UTF-8");
                conn.setConnectTimeout(10000);
                conn.setReadTimeout(10000);
                conn.setDoOutput(true);
                String jsonInputString = createRequestBody("drink", str).toString();
                OutputStream os = conn.getOutputStream();
                os.write(jsonInputString.getBytes("UTF-8"));
                os.flush();

                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                while ((inputLine = in.readLine()) != null) {
                    outResult.append(inputLine);
                }
                if(!outResult.toString().contains("None")) {
                    Product product = productDAO.selectProductByname(outResult.toString());
                    ProductCamResponseDto productCamResponseDto = new ProductCamResponseDto();
                    productCamResponseDto.setName(product.getName());
                    productCamResponseDto.setDrinkIdx(product.getId());
                    returnStr.add(productCamResponseDto);
                    conn.disconnect();
                }
            }


        }catch(Exception e){
            e.printStackTrace();
        }

        return returnStr;
    }

    public List<FoodCamResponseDto> camGetF(List<String> strings) throws IOException {

        List<FoodCamResponseDto> returnStr = new ArrayList<>();
        URL url = new URL(nlpUrl);
        try{

            for(String str : strings) {
                String inputLine = null;
                StringBuffer outResult = new StringBuffer();
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestProperty("Content-Type", "application/json");
                conn.setRequestProperty("Accept-Charset", "UTF-8");
                conn.setConnectTimeout(10000);
                conn.setReadTimeout(10000);
                conn.setDoOutput(true);
                String jsonInputString = createRequestBody("food", str).toString();
                OutputStream os = conn.getOutputStream();
                os.write(jsonInputString.getBytes("UTF-8"));
                os.flush();

                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
                while ((inputLine = in.readLine()) != null) {
                    outResult.append(inputLine);
                }
                if(!outResult.toString().contains("None")) {
                    Food food = foodDAO.getFoodByName(outResult.toString());
                    FoodCamResponseDto foodCamResponseDto = new FoodCamResponseDto();
                    foodCamResponseDto.setName(food.getName());
                    foodCamResponseDto.setFoodIdx(food.getId());
                    returnStr.add(foodCamResponseDto);
                    conn.disconnect();
                }
            }


        }catch(Exception e){
            e.printStackTrace();
        }

        return returnStr;
    }
    public JSONObject createRequestBody(String modeString, String inputstr){
        JSONObject body = new JSONObject();

        body.put("mode", modeString);
        body.put("inputstring", inputstr);
        return body;
    }
}
