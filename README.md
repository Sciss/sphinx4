[![Build Status](https://travis-ci.org/Sciss/sphinx4.svg?branch=master)](https://travis-ci.org/Sciss/sphinx4)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/de.sciss/sphinx4/badge.svg)](https://maven-badges.herokuapp.com/maven-central/de.sciss/sphinx4)

__Note:__ This is a fork that uses sbt as a build system instead of Gradle.
The following tests I could not get to run from the shell, however they can 
be individually run, for example from within IntelliJ IDEA:

- `edu.cmu.sphinx.frontend.AudioDataSourcesTest`
- `edu.cmu.sphinx.frontend.FrontendElementTest`
- `edu.cmu.sphinx.tools.bandwidth.BandDetectorTest`

To run the samples:

    sbt 'sphinx4-samples/run name'

This fork is published to Maven central using my group-id `de.sciss` and
a different stable version than the original which is only available as
snapshot version:

    "de.sciss" % "sphinx4" % v

The current version `v` in this scheme is `"1.0.0"`. The above artifact
combines `"sphinx4-core"` (library only) and `"sphinx4-data"` (English 
language data).

Below is the original README.

Sphinx-4 Speech Recognition System
-------------------------------------------------------------------

Sphinx-4 is a state-of-the-art, speaker-independent, continuous speech
recognition system written entirely in the Java programming language. It
was created via a joint collaboration between the Sphinx group at
Carnegie Mellon University, Sun Microsystems Laboratories, Mitsubishi
Electric Research Labs (MERL), and Hewlett Packard (HP), with
contributions from the University of California at Santa Cruz (UCSC) and
the Massachusetts Institute of Technology (MIT).

The design of Sphinx-4 is based on patterns that have emerged from the
design of past systems as well as new requirements based on areas that
researchers currently want to explore.  To exercise this framework, and
to provide researchers with a "research-ready" system, Sphinx-4 also
includes several implementations of both simple and state-of-the-art
techniques.  The framework and the implementations are all freely
available via open source under a very generous BSD-style license.

Because it is written entirely in the Java programming language, Sphinx-4
can run on a variety of platforms without requiring any special
compilation or changes.  We've tested Sphinx-4 on the following platforms
with success.

To get started with sphinx4 visit our wiki

    http://cmusphinx.sourceforge.net/wiki

Please give Sphinx-4 a try and post your questions, comments, and
feedback to one of the CMU Sphinx Forums:

    http://sourceforge.net/p/cmusphinx/discussion/sphinx4
    
We can also be reached at cmusphinx-devel@lists.sourceforge.net.

Sincerely,

The Sphinx-4 Team:  
(in alph. order)    

- Evandro Gouvea, CMU (developer and speech advisor)
- Peter Gorniak, MIT (developer)
- Philip Kwok, Sun Labs (developer)
- Paul Lamere, Sun Labs (design/technical lead)
- Beth Logan, HP (speech advisor)
- Pedro Moreno, Google (speech advisor)
- Bhiksha Raj, MERL (design lead)
- Mosur Ravishankar, CMU (speech advisor)
- Bent Schmidt-Nielsen, MERL (speech advisor)
- Rita Singh, CMU/MIT (design/speech advisor)
- JM Van Thong, HP (speech advisor)
- Willie Walker, Sun Labs (overall lead)
- Manfred Warmuth, USCS (speech advisor)
- Joe Woelfel, MERL (developer and speech advisor)
- Peter Wolf, MERL (developer and speech advisor)
