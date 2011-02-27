package de.ipponsoft.mda.fitnesse;
import java.io.File;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import fitnesse.trinidad.FitNesseRepository;
import fitnesse.trinidad.FitTestEngine;
import fitnesse.trinidad.JUnitHelper;
import fitnesse.trinidad.TestRunner;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class InteractionFixtureTest {

	@Parameters
	public static Collection<Object[]> data() {
		// the commented-out lines for 'givens' allow the viewer to be run			
		return Arrays.asList(new Object[][]{
				
//				{"ClaimsAppSuite.ClaimsSuite.GivenApproverSuite"},
//				{"ClaimsAppSuite.ClaimsSuite.GivenApproverSuite.WhenCreateClaimSuite.ThenDefaultsOkTest"},

//				{"ClaimsAppSuite.ClaimsSuite.GivenNewClaimSuite"},
//				{"ClaimsAppSuite.ClaimsSuite.GivenNewClaimSuite.WhenModifyAndSaveClaimSuite.ThenSavedOkTest"},

//				{"ClaimsAppSuite.EmployeesSuite.GivenEmployeesSuite"},
//				{"ClaimsAppSuite.EmployeesSuite.GivenEmployeesSuite.WhenListAllSuite.ThenAllReturnedTest"},
//				{"ClaimsAppSuite.EmployeesSuite.GivenEmployeesSuite.WhenListAllSuite.ThenCertainReturnedTest"},

//				{"ClaimsAppSuite.ZzzDebuggingAndDiagnostics"},
		});
	}
	
	private final String testPage;
	private TestRunner testRunner;
	private JUnitHelper helper;
	
	public InteractionFixtureTest(String testPage) {
		this.testPage = testPage;
	}

	@Before
	public void initHelper() throws Exception {
		String fitnesseTempDir = new File(System.getProperty("java.io.tmpdir"),
				"fitnesse").getAbsolutePath();
		testRunner = new TestRunner(
				new FitNesseRepository("src/main/resources"),
				new FitTestEngine(), fitnesseTempDir);
		helper = new JUnitHelper(testRunner);
	}

	@Test
	public void runFitnesseTest() throws Exception {
		helper.assertTestPasses(testPage);
	}


}