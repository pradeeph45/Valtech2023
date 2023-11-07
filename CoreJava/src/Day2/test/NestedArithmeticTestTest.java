package Day2.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class NestedArithmeticTestTest {
    @Nested
	class Add{
		
		@Test
		void testAddForAddPositiveNos() {
			
		}
		@Test
		void testAddForNegativeNos() {
			
		}
		
		@Test
		void testAddWithZero() {
			
		}
	}
	@Nested
	class Sub{
	  @Test
		void testSubForPositiveNos() {
			
		}
		@Test
		void testSubForNegativeNos() {
			
		}
		@Test
		void testSubWithZero() {
			
		}
		
	}
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
