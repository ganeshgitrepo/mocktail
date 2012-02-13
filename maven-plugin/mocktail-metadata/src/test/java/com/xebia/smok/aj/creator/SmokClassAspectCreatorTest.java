package com.xebia.smok.aj.creator;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.DirectFieldAccessor;

import com.xebia.smok.SmokContainer;
import com.xebia.smok.SmokContext;
import com.xebia.smok.SmokObjectMother;
import com.xebia.smok.xml.domain.Smok;
import com.xebia.smok.xml.domain.SmokMode;

public class SmokClassAspectCreatorTest {

	@Mock
	File aspectsRootDir;
	
	@Before
	public void setup(){
		SmokContainer.initializeContainer("");
		SmokContext smokContext = SmokContext.getSmokContext();
		DirectFieldAccessor dfa = new DirectFieldAccessor(smokContext);
		//Need to set as Smok Context is a singleton class and is getting set-upped from multiple places
		dfa.setPropertyValue("recordingDirectory", "root_dir");
	}
	
	@Test
	public void shouldCreateRecordingAspectForClass() throws Exception {
		
		final Smok classSmok = SmokObjectMother.createClassSmok("AspectedClass", "com.sandy");
		
		new SmokClassAspectCreator(SmokMode.RECORDING_MODE) {
			@Override
			protected void createAspectFile(Smok smok, String aspectFileName, File aspectsRootDirecotry,
					String templatedClassObjectString) throws IOException {
				assertThat(aspectFileName, is(classSmok.getClassName()));
				assertThat(templatedClassObjectString, containsString("public aspect RecorderAspectAspectedClass"));
				assertThat(templatedClassObjectString, containsString("String fqcn = \"com.sandy.AspectedClass\";"));
				assertThat(templatedClassObjectString, containsString("recordingDirectoryPath = \"root_dir\";"));
				assertThat(templatedClassObjectString, containsString("pointcut callPointcut() : call(* com.sandy.AspectedClass.*(..));"));
				System.out.println(templatedClassObjectString);
			}
		}.createAspect(classSmok, aspectsRootDir);
	}
	
	@Test
	public void shouldCreateRecordingAspectForClassWithoutPackage() throws Exception {
	
		final Smok classSmok = SmokObjectMother.createClassSmok("name", "");
		new SmokClassAspectCreator(SmokMode.RECORDING_MODE) {
			@Override
			protected void createAspectFile(Smok smok, String fileName, File directory,
					String templatedClassObjectString) throws IOException {
				assertThat(fileName, is(classSmok.getClassName()));
				assertThat(templatedClassObjectString, containsString("public aspect RecorderAspectname"));
				assertThat(templatedClassObjectString, containsString("String fqcn = \"name\";"));
				assertThat(templatedClassObjectString, containsString("recordingDirectoryPath = \"root_dir\";"));
				assertThat(templatedClassObjectString, containsString("pointcut callPointcut() : call(* name.*(..));"));
			}
		}.createAspect(classSmok, aspectsRootDir);
	}

	@Test
	public void shouldCreatePlaybackAspectForClass() throws Exception {
	
		final Smok classSmok = SmokObjectMother.createClassSmok("AspectedClass", "com.sandy");
		new SmokClassAspectCreator(SmokMode.PLAYBACK_MODE) {
			@Override
			protected void createAspectFile(Smok smok, String fileName, File directory,
					String templatedClassObjectString) throws IOException {
				System.out.println(templatedClassObjectString);
				assertThat(fileName, is(classSmok.getClassName()));
				assertThat(templatedClassObjectString, containsString("public aspect AspectAspectedClass"));
				assertThat(templatedClassObjectString, containsString("String fqcn = \"com.sandy.AspectedClass\";"));
				assertThat(templatedClassObjectString, containsString("recordingDirectoryPath = \"root_dir\";"));
				assertThat(templatedClassObjectString, containsString("pointcut callPointcut() : call(* com.sandy.AspectedClass.*(..));"));
			}
		}.createAspect(classSmok, aspectsRootDir);
	}
	
	@Test
	public void shouldCreatePlaybackAspectForClassWithoutPackage() throws Exception {
	
		final Smok classSmok = SmokObjectMother.createClassSmok("name", "");
		new SmokClassAspectCreator(SmokMode.PLAYBACK_MODE) {
			@Override
			protected void createAspectFile(Smok smok, String fileName, File directory,
					String templatedClassObjectString) throws IOException {
				assertThat(fileName, is(classSmok.getClassName()));
				assertThat(templatedClassObjectString, containsString("public aspect Aspectname"));
				assertThat(templatedClassObjectString, containsString("String fqcn = \"name\";"));
				assertThat(templatedClassObjectString, containsString("recordingDirectoryPath = \"root_dir\";"));
				assertThat(templatedClassObjectString, containsString("pointcut callPointcut() : call(* name.*(..));"));
			}
		}.createAspect(classSmok, aspectsRootDir);
	}
}
