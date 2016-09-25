package csc207;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCommands {
	
	Command cmd = new Command();
	
	@Test
	public void testExecuteCommand() {
		FileSystem fs = new FileSystem(); 
		String str = new String("Chinese Food");
		assertEquals(cmd.executeCommand(fs, str), fs);
	}
	
	@Test
	public void testGetArgs() {
		String str = new String("Chinese Food");
		assertEquals(cmd.getArgs(str),str.split(" ")); 
	}
	
	@Test
	public void testErrorMessage() {
		String str = new String("error");
		assertEquals(cmd.errorMessage(str),str); 		
	}
	
	@Test
	public void testGetArgumentNumberZeroArguments() {
		String str = new String("");
		assertEquals(cmd.getArgumentNumber(str),0); 		
	}
	
	@Test
	public void testGetArgumentNumberTwoArguments() {
		String str = new String("canada dog cat");
		assertEquals(cmd.getArgumentNumber(str),3); 		
	}	

}
