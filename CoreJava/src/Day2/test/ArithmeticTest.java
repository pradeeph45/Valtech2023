package Day2.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import Day2.ArithmeticImpl;
import Day2.DivideByZeroException;
import Day2.Arithmetic;
@DisplayName("Arithmetic Tests")
class ArithmeticTest {
  private Arithmetic arithmetic;//=new ArithmeticImpl();
	
  @BeforeAll
  static void beforeAll() {
	  System.out.println("Before Everyone");
  }
  
  @AfterAll
  static void afterAll() {
	  System.out.println("After Everyone");
  }
  
  @BeforeEach
  void beforeEach() {
	  System.out.println("Init....");
	 arithmetic=new ArithmeticImpl();
  }
  
  @AfterEach
  void afterEach() {
	  System.out.println("Destroy...");
  }
  
  @Test
	void testAdd() {
		assertEquals(5,arithmetic.add(2, 3));
		assertEquals(5,arithmetic.add(3, 2));
		assertEquals(5,arithmetic.add(5, 0));
		assertEquals(5,arithmetic.add(5, -0));
		assertEquals(5,arithmetic.add(2, 3));
		assertEquals(-5,arithmetic.add(-2, -3));
		assertEquals(-5,arithmetic.add(-8, 3));
	}

	@Test
	void testSub() {
		
	}

	@Test
	void testMul() {
		
	}
	
	static Stream<Arguments> addArgsGenerator(){
		return Stream.of(Arguments.of(1,2,3),Arguments.of(-1,-2,-3),Arguments.of(1,-2,-1),Arguments.of(-1,2,1));
	}
	
	@ParameterizedTest(name = "Add with Method {0} + {1} = {2}")
	@MethodSource(value =  {"addArgsGenerator"})
	 void testWithMethod(int a,int b,int c) {
    assertEquals(c, arithmetic.add(a, b));
	}
	
	@ParameterizedTest(name = "Add with CSV {0} + {1} = {2}")
	@CsvFileSource(files = {"add.csv"})
	 void testWithCSVFile(int a,int b,int c) {
    assertEquals(c, arithmetic.add(a, b));
	}
	
	@ParameterizedTest(name = "Add with CSV {0} + {1} = {2}")
	@CsvSource(value = {"2,3,5","-2,3,1","-1,-1,-2"})
	 void testWithCSVParams(int a,int b,int c) {
    assertEquals(c, arithmetic.add(a, b));
	}
	@ParameterizedTest(name = "Add with {0}")
	@ValueSource(strings = {"2,3,5","-2,3,1","-1,-1,-2"})
	void testAddWithParams(String value) {
		String [] parts=value.split(",");
		List<Integer> values=Arrays.asList(parts).stream().map(it -> Integer.parseInt(it)).collect(Collectors.toList());
		assertEquals(values.get(2),arithmetic.add(values.get(0), values.get(1)));
	}
	
	void testDivByZero() {
		assertThrows(DivideByZeroException.class, ()->arithmetic.div(5,0));
	}

	@Test
	void testDiv() {
		assertEquals(1.666,5.0/3,0.001,"Value Not in Range");
		assertEquals(2, arithmetic.div(4,2));
		assertEquals(2, arithmetic.div(-6,-3));
		try {
		assertEquals(2, arithmetic.div(4,0));
		fail("Should have thrown Arithmetic Exception");
		}
		catch(DivideByZeroException e) {
			
		}
	}

}
