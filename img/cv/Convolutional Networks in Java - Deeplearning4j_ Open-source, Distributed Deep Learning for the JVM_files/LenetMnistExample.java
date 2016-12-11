if ( 'prettyPrint' in window ) {} else {
    document.write( '<script type="text/javascript" src="https://gist-it.appspot.com/assets/prettify/prettify.js"></script>' );
}


document.write( '<link rel="stylesheet" href="https://gist-it.appspot.com/assets/embed.css"/>' );


document.write( '<link rel="stylesheet" href="https://gist-it.appspot.com/assets/prettify/prettify.css"/>' );

document.write( '<div class="gist-it-gist">\n<div class="gist-file">\n    <div class="gist-data">\n        \n        <pre class="prettyprint">            Create an iterator using the batch size for one iteration\n         */\n        log.info("Load data....");\n        DataSetIterator mnistTrain = new MnistDataSetIterator(batchSize,true,12345);\n        DataSetIterator mnistTest = new MnistDataSetIterator(batchSize,false,12345);\n\n        /*\n            Construct the neural network\n         */\n        log.info("Build model....");\n        MultiLayerConfiguration.Builder builder = new NeuralNetConfiguration.Builder()\n                .seed(seed)\n                .iterations(iterations) // Training iterations as above\n                .regularization(true).l2(0.0005)\n                /*\n                    Uncomment the following for learning decay and bias\n                 */\n                .learningRate(.01)//.biasLearningRate(0.02)\n                //.learningRateDecayPolicy(LearningRatePolicy.Inverse).lrPolicyDecayRate(0.001).lrPolicyPower(0.75)\n                .weightInit(WeightInit.XAVIER)\n                .optimizationAlgo(OptimizationAlgorithm.STOCHASTIC_GRADIENT_DESCENT)\n                .updater(Updater.NESTEROVS).momentum(0.9)\n                .list()\n                .layer(0, new ConvolutionLayer.Builder(5, 5)\n                        //nIn and nOut specify depth. nIn here is the nChannels and nOut is the number of filters to be applied\n                        .nIn(nChannels)\n                        .stride(1, 1)\n                        .nOut(20)\n                        .activation("identity")\n                        .build())\n                .layer(1, new SubsamplingLayer.Builder(SubsamplingLayer.PoolingType.MAX)\n                        .kernelSize(2,2)\n                        .stride(2,2)\n                        .build())\n                .layer(2, new ConvolutionLayer.Builder(5, 5)\n                        //Note that nIn need not be specified in later layers\n                        .stride(1, 1)\n                        .nOut(50)\n                        .activation("identity")\n                        .build())\n                .layer(3, new SubsamplingLayer.Builder(SubsamplingLayer.PoolingType.MAX)\n                        .kernelSize(2,2)\n                        .stride(2,2)\n                        .build())</pre>\n        \n    </div>\n    \n    <div class="gist-meta">\n        \n        <span><a href="https://github.com/deeplearning4j/dl4j-examples/blob/master/dl4j-examples/src/main/java/org/deeplearning4j/examples/convolution/LenetMnistExample.java">This Gist</a> brought to you by <a href="https://gist-it.appspot.com">gist-it</a>.</span>\n        \n        <span style="float: right; color: #369;"><a href="https://github.com/deeplearning4j/dl4j-examples/raw/master/dl4j-examples/src/main/java/org/deeplearning4j/examples/convolution/LenetMnistExample.java">view raw</a></span>\n        <span style="float: right; margin-right: 8px;">\n            <a style="color: rgb(102, 102, 102);" href="https://github.com/deeplearning4j/dl4j-examples/blob/master/dl4j-examples/src/main/java/org/deeplearning4j/examples/convolution/LenetMnistExample.java">dl4j-examples/src/main/java/org/deeplearning4j/examples/convolution/LenetMnistExample.java</a></span>\n            <!-- Generated by: https://gist-it.appspot.com -->\n    </div>\n    \n</div>\n</div>' );

document.write( '<script type="text/javascript">prettyPrint();</script>' );