package org.mocktail;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.mocktail.repository.ObjectRepository;

public class MethodMocktail implements Serializable{
    private static final long serialVersionUID = 1L;

    private static final String NOT_AVAIL = "?";

    MocktailContainer container = MocktailContainer.getInstance();
    
    Map<String, Integer> methodCallsMap = new HashMap<String, Integer>();

    private String methodName;

    private String fqcn;

    private String recordingDirectoryPath;

    private String recordingBasePath = "";

    public String getFqcn() {
        return fqcn;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setUp(Object object) {
        container.setMethodMocktail(this);
        StackTraceElement element = null;
        fqcn = object.getClass().getName();
        element = getStackTraceElement(this.getClass().getName(), Thread.currentThread()
                .getStackTrace());
        methodName = element.getMethodName();
        System.out.println("Inside setup:"+methodName);
    }



    public void close() {
        container.resetMethodMocktail();
        if(!serializedObjectExistsOnDisk()){
            saveSerializedIndicatorOnDisk();
        }
        System.out.println("Calling MethodMocktail.close() method");
    }
    
    public boolean isPlaybackMode(){
        return serializedObjectExistsOnDisk();
    }
    
    private boolean serializedObjectExistsOnDisk() {
        String fileSeparator = "/";
        recordingDirectoryPath = recordingBasePath;
        recordingDirectoryPath += fileSeparator + fqcn.replaceAll("\\.", fileSeparator) + fileSeparator+methodName;

        ObjectRepository objectRepository = MocktailContainer.getInstance().getObjectRepository();
        return objectRepository.objectAlreadyExist(methodName,
                recordingDirectoryPath);
    }

    private void saveSerializedIndicatorOnDisk() {
        if (!(new File(recordingDirectoryPath)).exists()) {
            (new File(recordingDirectoryPath)).mkdirs();
        }
        String recordingFileName = methodName;
        
        ObjectRepository objectRepository = MocktailContainer.getInstance().getObjectRepository();
        objectRepository.saveObject(methodName, recordingFileName,
                recordingDirectoryPath);
    }

    private StackTraceElement getStackTraceElement(String fqcn,
            StackTraceElement[] stackTrace) {
        if (fqcn == null) {
            return null;
        }
        boolean next = false;
        for (StackTraceElement element : stackTrace) {
            if (next) {
                return element;
            }
            String className = element.getClassName();
            if (fqcn.equals(className)) {
                next = true;
            } else if (NOT_AVAIL.equals(className)) {
                break;
            }
        }
        return null;
    }
    
    public void setRecordingBasePath(String recordingBasePath) {
        this.recordingBasePath = recordingBasePath;
    }

    public String getRecordingDirectoryPath() {
        return recordingDirectoryPath;
    }
    
    public void registerWithMethodCallsMap(String key) {
        if(methodCallsMap.containsKey(key)){
            Integer numberOfCalls = methodCallsMap.get(key);
            numberOfCalls = new Integer(numberOfCalls.intValue()+1);
            methodCallsMap.put(key, numberOfCalls);
        } else{
            methodCallsMap.put(key, new Integer(1));
        }
    }
    
    public int getMethodCalls(String key) {
        if(methodCallsMap.containsKey(key)){
            return methodCallsMap.get(key).intValue();
        }
        return 0;
    }
}
