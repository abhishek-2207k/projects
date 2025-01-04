package com.restaraunt.restaraunt_test;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.restaraunt.entities.Restaraunt;
import com.restaraunt.repositories.RestarauntRepo;
import com.restaraunt.service.RestarauntServiceImpl;
import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest(classes = {RestarauntServiceTest.class})
public class RestarauntServiceTest {
    
    @Mock
    RestarauntRepo rr;
    @InjectMocks
    RestarauntServiceImpl rsi;
    public Restaraunt res;
    
    @Test
    @Order(1)
    public void getRestarauntByName()
    {
       Restaraunt res=new Restaraunt(1, "SpicyFood", "Balangir", "200", "Indian", "100-200");
       
       String resname="SpicyFood";
      when(rr.findByName(resname)).thenReturn(res);
       assertEquals(resname,rsi.showByName(resname).getName());
    }
    
    @Test
    @Order(2)
    public void getRestarauntByLocation()
    {
       Restaraunt res=new Restaraunt(1, "SpicyFood", "Balangir", "200", "Indian", "100-200");
       
       String location="Balangir";
      when(rr.findBylocation(location)).thenReturn(res);
       assertEquals(location,rsi.showByLocation(location).getLocation());
    }
    
    @Test
    @Order(3)
    public void getRestarauntByBudget()
    {
       Restaraunt res=new Restaraunt(1, "SpicyFood", "Balangir", "200", "Indian", "100-200");
       
       String budget="100-200";
      when(rr.findByBudget(budget)).thenReturn(res);
       assertEquals(budget,rsi.showByBudget(budget).getBudget());
    }
   
    
    @Test
    @Order(4)
    public void getRestarauntByCuisine()
    {
       Restaraunt res=new Restaraunt(1, "SpicyFood", "Balangir", "200", "Indian", "100-200");
       
       String cuisine="Indian";
      when(rr.findByCuisine(cuisine)).thenReturn(res);
       assertEquals(cuisine,rsi.showByCuisine(cuisine).getCuisine());
    }
   
    @Test
    @Order(5)
    public void getRestarauntByDistance()
    {
       Restaraunt res=new Restaraunt(1, "SpicyFood", "Balangir", "200", "Indian", "100-200");
       
       String distance="200";
      when(rr.findByDistance(distance)).thenReturn(res);
       assertEquals(distance,rsi.showByDistance(distance).getDistance());
    }
   
   
    
   

}
