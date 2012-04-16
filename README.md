# lein-iclojure

IClojure plugin for Leiningen.

## Installation

```
lein plugin install lein-iclojure 1.0
```

## Usage

To launch an IClojure REPL within the context of a project you'll have to use `trampoline`.

```
lein trampoline irepl
```

To launch a standalone IClojure REPL you can simply run

```
lein irepl
```

### Trampoline and project classpath

By default the current version of Leiningen runs code that needs a
project classpath in a subprocess. The problem is this blocks access
to user input, and is therefore not appropriate for IClojure.

We can try to cheat by running IClojure in a separate classloader,
however this won't provide the necessary classpath isolation. For
example, IClojure will use the version of Clojure that ships with
Leiningen (1.2.1) instead of the version required by the project.

Therefore the only available option is to use `trampoline`. This is a
facility provided by Leiningen to get around the limitations
above. When running a task within trampoline, Leiningen will execute
that task after Leiningen's JVM exit.

## License

Copyright (C) 2012 Cosmin Stejerean

Distributed under the Eclipse Public License, the same as Clojure.
